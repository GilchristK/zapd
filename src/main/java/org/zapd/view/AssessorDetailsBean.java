package org.zapd.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.zapd.model.AssessorDetails;

/**
 * Backing bean for AssessorDetails entities.
 * <p/>
 * This class provides CRUD functionality for all AssessorDetails entities. It
 * focuses purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt>
 * for state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD
 * framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class AssessorDetailsBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving AssessorDetails entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private AssessorDetails assessorDetails;

	public AssessorDetails getAssessorDetails() {
		return this.assessorDetails;
	}

	public void setAssessorDetails(AssessorDetails assessorDetails) {
		this.assessorDetails = assessorDetails;
	}

	@Inject
	private Conversation conversation;

	@PersistenceContext(unitName = "zapd-persistence-unit", type = PersistenceContextType.EXTENDED)
	private EntityManager entityManager;

	public String create() {

		this.conversation.begin();
		this.conversation.setTimeout(1800000L);
		return "create?faces-redirect=true";
	}

	public void retrieve() {

		if (FacesContext.getCurrentInstance().isPostback()) {
			return;
		}

		if (this.conversation.isTransient()) {
			this.conversation.begin();
			this.conversation.setTimeout(1800000L);
		}

		if (this.id == null) {
			this.assessorDetails = this.example;
		} else {
			this.assessorDetails = findById(getId());
		}
	}

	public AssessorDetails findById(Long id) {

		return this.entityManager.find(AssessorDetails.class, id);
	}

	/*
	 * Support updating and deleting AssessorDetails entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.assessorDetails);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.assessorDetails);
				return "view?faces-redirect=true&id="
						+ this.assessorDetails.getId();
			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(e.getMessage()));
			return null;
		}
	}

	public String delete() {
		this.conversation.end();

		try {
			AssessorDetails deletableEntity = findById(getId());

			this.entityManager.remove(deletableEntity);
			this.entityManager.flush();
			return "search?faces-redirect=true";
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(e.getMessage()));
			return null;
		}
	}

	/*
	 * Support searching AssessorDetails entities with pagination
	 */

	private int page;
	private long count;
	private List<AssessorDetails> pageItems;

	private AssessorDetails example = new AssessorDetails();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public AssessorDetails getExample() {
		return this.example;
	}

	public void setExample(AssessorDetails example) {
		this.example = example;
	}

	public String search() {
		this.page = 0;
		return null;
	}

	public void paginate() {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();

		// Populate this.count

		CriteriaQuery<Long> countCriteria = builder.createQuery(Long.class);
		Root<AssessorDetails> root = countCriteria.from(AssessorDetails.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<AssessorDetails> criteria = builder
				.createQuery(AssessorDetails.class);
		root = criteria.from(AssessorDetails.class);
		TypedQuery<AssessorDetails> query = this.entityManager
				.createQuery(criteria.select(root).where(
						getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<AssessorDetails> root) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicatesList = new ArrayList<Predicate>();

		String assessorName = this.example.getAssessorName();
		if (assessorName != null && !"".equals(assessorName)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("assessorName")),
					'%' + assessorName.toLowerCase() + '%'));
		}
		String sex = this.example.getSex();
		if (sex != null && !"".equals(sex)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("sex")),
					'%' + sex.toLowerCase() + '%'));
		}
		String designation = this.example.getDesignation();
		if (designation != null && !"".equals(designation)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("designation")),
					'%' + designation.toLowerCase() + '%'));
		}
		String identity = this.example.getIdentity();
		if (identity != null && !"".equals(identity)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("identity")),
					'%' + identity.toLowerCase() + '%'));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<AssessorDetails> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back AssessorDetails entities (e.g. from
	 * inside an HtmlSelectOneMenu)
	 */

	public List<AssessorDetails> getAll() {

		CriteriaQuery<AssessorDetails> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(AssessorDetails.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(AssessorDetails.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final AssessorDetailsBean ejbProxy = this.sessionContext
				.getBusinessObject(AssessorDetailsBean.class);

		return new Converter() {

			@Override
			public Object getAsObject(FacesContext context,
					UIComponent component, String value) {

				return ejbProxy.findById(Long.valueOf(value));
			}

			@Override
			public String getAsString(FacesContext context,
					UIComponent component, Object value) {

				if (value == null) {
					return "";
				}

				return String.valueOf(((AssessorDetails) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private AssessorDetails add = new AssessorDetails();

	public AssessorDetails getAdd() {
		return this.add;
	}

	public AssessorDetails getAdded() {
		AssessorDetails added = this.add;
		this.add = new AssessorDetails();
		return added;
	}
}
