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

import org.zapd.model.Cases;

/**
 * Backing bean for Cases entities.
 * <p/>
 * This class provides CRUD functionality for all Cases entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD
 * framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class CasesBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving Cases entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private Cases cases;

	public Cases getCases() {
		return this.cases;
	}

	public void setCases(Cases cases) {
		this.cases = cases;
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
			this.cases = this.example;
		} else {
			this.cases = findById(getId());
		}
	}

	public Cases findById(Long id) {

		return this.entityManager.find(Cases.class, id);
	}

	/*
	 * Support updating and deleting Cases entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.cases);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.cases);
				return "view?faces-redirect=true&id=" + this.cases.getId();
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
			Cases deletableEntity = findById(getId());

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
	 * Support searching Cases entities with pagination
	 */

	private int page;
	private long count;
	private List<Cases> pageItems;

	private Cases example = new Cases();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public Cases getExample() {
		return this.example;
	}

	public void setExample(Cases example) {
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
		Root<Cases> root = countCriteria.from(Cases.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<Cases> criteria = builder.createQuery(Cases.class);
		root = criteria.from(Cases.class);
		TypedQuery<Cases> query = this.entityManager.createQuery(criteria
				.select(root).where(getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<Cases> root) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicatesList = new ArrayList<Predicate>();

		String referenceNumber = this.example.getReferenceNumber();
		if (referenceNumber != null && !"".equals(referenceNumber)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("referenceNumber")),
					'%' + referenceNumber.toLowerCase() + '%'));
		}
		String reasonOfComplaint = this.example.getReasonOfComplaint();
		if (reasonOfComplaint != null && !"".equals(reasonOfComplaint)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("reasonOfComplaint")),
					'%' + reasonOfComplaint.toLowerCase() + '%'));
		}
		String complaintDate = this.example.getComplaintDate();
		if (complaintDate != null && !"".equals(complaintDate)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("complaintDate")),
					'%' + complaintDate.toLowerCase() + '%'));
		}
		String actionTaken = this.example.getActionTaken();
		if (actionTaken != null && !"".equals(actionTaken)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("actionTaken")),
					'%' + actionTaken.toLowerCase() + '%'));
		}
		String resolutionDate = this.example.getResolutionDate();
		if (resolutionDate != null && !"".equals(resolutionDate)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("resolutionDate")),
					'%' + resolutionDate.toLowerCase() + '%'));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<Cases> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back Cases entities (e.g. from inside an
	 * HtmlSelectOneMenu)
	 */

	public List<Cases> getAll() {

		CriteriaQuery<Cases> criteria = this.entityManager.getCriteriaBuilder()
				.createQuery(Cases.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(Cases.class))).getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final CasesBean ejbProxy = this.sessionContext
				.getBusinessObject(CasesBean.class);

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

				return String.valueOf(((Cases) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private Cases add = new Cases();

	public Cases getAdd() {
		return this.add;
	}

	public Cases getAdded() {
		Cases added = this.add;
		this.add = new Cases();
		return added;
	}
}
