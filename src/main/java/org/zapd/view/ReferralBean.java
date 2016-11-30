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

import org.zapd.model.Referral;

/**
 * Backing bean for Referral entities.
 * <p/>
 * This class provides CRUD functionality for all Referral entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD
 * framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class ReferralBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving Referral entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private Referral referral;

	public Referral getReferral() {
		return this.referral;
	}

	public void setReferral(Referral referral) {
		this.referral = referral;
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
			this.referral = this.example;
		} else {
			this.referral = findById(getId());
		}
	}

	public Referral findById(Long id) {

		return this.entityManager.find(Referral.class, id);
	}

	/*
	 * Support updating and deleting Referral entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.referral);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.referral);
				return "view?faces-redirect=true&id=" + this.referral.getId();
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
			Referral deletableEntity = findById(getId());

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
	 * Support searching Referral entities with pagination
	 */

	private int page;
	private long count;
	private List<Referral> pageItems;

	private Referral example = new Referral();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public Referral getExample() {
		return this.example;
	}

	public void setExample(Referral example) {
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
		Root<Referral> root = countCriteria.from(Referral.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<Referral> criteria = builder.createQuery(Referral.class);
		root = criteria.from(Referral.class);
		TypedQuery<Referral> query = this.entityManager.createQuery(criteria
				.select(root).where(getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<Referral> root) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicatesList = new ArrayList<Predicate>();

		String dmisNumber = this.example.getDmisNumber();
		if (dmisNumber != null && !"".equals(dmisNumber)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("dmisNumber")),
					'%' + dmisNumber.toLowerCase() + '%'));
		}
		String startDate = this.example.getStartDate();
		if (startDate != null && !"".equals(startDate)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("startDate")),
					'%' + startDate.toLowerCase() + '%'));
		}
		String endDate = this.example.getEndDate();
		if (endDate != null && !"".equals(endDate)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("endDate")),
					'%' + endDate.toLowerCase() + '%'));
		}
		String locationOfService = this.example.getLocationOfService();
		if (locationOfService != null && !"".equals(locationOfService)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("locationOfService")),
					'%' + locationOfService.toLowerCase() + '%'));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<Referral> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back Referral entities (e.g. from inside an
	 * HtmlSelectOneMenu)
	 */

	public List<Referral> getAll() {

		CriteriaQuery<Referral> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(Referral.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(Referral.class))).getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final ReferralBean ejbProxy = this.sessionContext
				.getBusinessObject(ReferralBean.class);

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

				return String.valueOf(((Referral) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private Referral add = new Referral();

	public Referral getAdd() {
		return this.add;
	}

	public Referral getAdded() {
		Referral added = this.add;
		this.add = new Referral();
		return added;
	}
}
