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

import org.zapd.model.AssessmentDetails;

/**
 * Backing bean for AssessmentDetails entities.
 * <p/>
 * This class provides CRUD functionality for all AssessmentDetails entities. It
 * focuses purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt>
 * for state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD
 * framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class AssessmentDetailsBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving AssessmentDetails entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private AssessmentDetails assessmentDetails;

	public AssessmentDetails getAssessmentDetails() {
		return this.assessmentDetails;
	}

	public void setAssessmentDetails(AssessmentDetails assessmentDetails) {
		this.assessmentDetails = assessmentDetails;
	}

	@Inject
	private Conversation conversation;

	@PersistenceContext(unitName = "zapd-persistence-unit", type = PersistenceContextType.EXTENDED)
	private EntityManager entityManager;

	public String create() {

		if(this.conversation.isTransient()){
			this.conversation.begin();
			this.conversation.setTimeout(1800000L);
		}
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
			this.assessmentDetails = this.example;
		} else {
			this.assessmentDetails = findById(getId());
		}
	}

	public AssessmentDetails findById(Long id) {

		return this.entityManager.find(AssessmentDetails.class, id);
	}

	/*
	 * Support updating and deleting AssessmentDetails entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.assessmentDetails);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.assessmentDetails);
				return "view?faces-redirect=true&id="
						+ this.assessmentDetails.getId();
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
			AssessmentDetails deletableEntity = findById(getId());

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
	 * Support searching AssessmentDetails entities with pagination
	 */

	private int page;
	private long count;
	private List<AssessmentDetails> pageItems;

	private AssessmentDetails example = new AssessmentDetails();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public AssessmentDetails getExample() {
		return this.example;
	}

	public void setExample(AssessmentDetails example) {
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
		Root<AssessmentDetails> root = countCriteria
				.from(AssessmentDetails.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<AssessmentDetails> criteria = builder
				.createQuery(AssessmentDetails.class);
		root = criteria.from(AssessmentDetails.class);
		TypedQuery<AssessmentDetails> query = this.entityManager
				.createQuery(criteria.select(root).where(
						getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<AssessmentDetails> root) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicatesList = new ArrayList<Predicate>();

		String dmisNumber = this.example.getDmisNumber();
		if (dmisNumber != null && !"".equals(dmisNumber)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("dmisNumber")),
					'%' + dmisNumber.toLowerCase() + '%'));
		}
		String dateOfAssessment = this.example.getDateOfAssessment();
		if (dateOfAssessment != null && !"".equals(dateOfAssessment)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("dateOfAssessment")),
					'%' + dateOfAssessment.toLowerCase() + '%'));
		}
		String dateOfDisability = this.example.getDateOfDisability();
		if (dateOfDisability != null && !"".equals(dateOfDisability)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("dateOfDisability")),
					'%' + dateOfDisability.toLowerCase() + '%'));
		}
		String causeOfDisabilty = this.example.getCauseOfDisabilty();
		if (causeOfDisabilty != null && !"".equals(causeOfDisabilty)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("causeOfDisabilty")),
					'%' + causeOfDisabilty.toLowerCase() + '%'));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<AssessmentDetails> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back AssessmentDetails entities (e.g. from
	 * inside an HtmlSelectOneMenu)
	 */

	public List<AssessmentDetails> getAll() {

		CriteriaQuery<AssessmentDetails> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(AssessmentDetails.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(AssessmentDetails.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final AssessmentDetailsBean ejbProxy = this.sessionContext
				.getBusinessObject(AssessmentDetailsBean.class);

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

				return String.valueOf(((AssessmentDetails) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private AssessmentDetails add = new AssessmentDetails();

	public AssessmentDetails getAdd() {
		return this.add;
	}

	public AssessmentDetails getAdded() {
		AssessmentDetails added = this.add;
		this.add = new AssessmentDetails();
		return added;
	}
}
