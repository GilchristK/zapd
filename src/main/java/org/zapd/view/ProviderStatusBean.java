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

import org.zapd.model.ProviderStatus;

/**
 * Backing bean for ProviderStatus entities.
 * <p/>
 * This class provides CRUD functionality for all ProviderStatus entities. It
 * focuses purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt>
 * for state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD
 * framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class ProviderStatusBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving ProviderStatus entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private ProviderStatus providerStatus;

	public ProviderStatus getProviderStatus() {
		return this.providerStatus;
	}

	public void setProviderStatus(ProviderStatus providerStatus) {
		this.providerStatus = providerStatus;
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
			this.providerStatus = this.example;
		} else {
			this.providerStatus = findById(getId());
		}
	}

	public ProviderStatus findById(Long id) {

		return this.entityManager.find(ProviderStatus.class, id);
	}

	/*
	 * Support updating and deleting ProviderStatus entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.providerStatus);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.providerStatus);
				return "view?faces-redirect=true&id="
						+ this.providerStatus.getId();
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
			ProviderStatus deletableEntity = findById(getId());

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
	 * Support searching ProviderStatus entities with pagination
	 */

	private int page;
	private long count;
	private List<ProviderStatus> pageItems;

	private ProviderStatus example = new ProviderStatus();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public ProviderStatus getExample() {
		return this.example;
	}

	public void setExample(ProviderStatus example) {
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
		Root<ProviderStatus> root = countCriteria.from(ProviderStatus.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<ProviderStatus> criteria = builder
				.createQuery(ProviderStatus.class);
		root = criteria.from(ProviderStatus.class);
		TypedQuery<ProviderStatus> query = this.entityManager
				.createQuery(criteria.select(root).where(
						getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<ProviderStatus> root) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicatesList = new ArrayList<Predicate>();

		String description = this.example.getDescription();
		if (description != null && !"".equals(description)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("description")),
					'%' + description.toLowerCase() + '%'));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<ProviderStatus> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back ProviderStatus entities (e.g. from
	 * inside an HtmlSelectOneMenu)
	 */

	public List<ProviderStatus> getAll() {

		CriteriaQuery<ProviderStatus> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(ProviderStatus.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(ProviderStatus.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final ProviderStatusBean ejbProxy = this.sessionContext
				.getBusinessObject(ProviderStatusBean.class);

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

				return String.valueOf(((ProviderStatus) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private ProviderStatus add = new ProviderStatus();

	public ProviderStatus getAdd() {
		return this.add;
	}

	public ProviderStatus getAdded() {
		ProviderStatus added = this.add;
		this.add = new ProviderStatus();
		return added;
	}
}
