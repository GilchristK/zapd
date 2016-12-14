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

import org.zapd.model.TypeOfService;

/**
 * Backing bean for TypeOfService entities.
 * <p/>
 * This class provides CRUD functionality for all TypeOfService entities. It
 * focuses purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt>
 * for state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD
 * framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class TypeOfServiceBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving TypeOfService entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private TypeOfService typeOfService;

	public TypeOfService getTypeOfService() {
		return this.typeOfService;
	}

	public void setTypeOfService(TypeOfService typeOfService) {
		this.typeOfService = typeOfService;
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
			this.typeOfService = this.example;
		} else {
			this.typeOfService = findById(getId());
		}
	}

	public TypeOfService findById(Long id) {

		return this.entityManager.find(TypeOfService.class, id);
	}

	/*
	 * Support updating and deleting TypeOfService entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.typeOfService);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.typeOfService);
				return "view?faces-redirect=true&id="
						+ this.typeOfService.getId();
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
			TypeOfService deletableEntity = findById(getId());

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
	 * Support searching TypeOfService entities with pagination
	 */

	private int page;
	private long count;
	private List<TypeOfService> pageItems;

	private TypeOfService example = new TypeOfService();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public TypeOfService getExample() {
		return this.example;
	}

	public void setExample(TypeOfService example) {
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
		Root<TypeOfService> root = countCriteria.from(TypeOfService.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<TypeOfService> criteria = builder
				.createQuery(TypeOfService.class);
		root = criteria.from(TypeOfService.class);
		TypedQuery<TypeOfService> query = this.entityManager
				.createQuery(criteria.select(root).where(
						getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<TypeOfService> root) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicatesList = new ArrayList<Predicate>();

		String typeOfService = this.example.getTypeOfService();
		if (typeOfService != null && !"".equals(typeOfService)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("typeOfService")),
					'%' + typeOfService.toLowerCase() + '%'));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<TypeOfService> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back TypeOfService entities (e.g. from inside
	 * an HtmlSelectOneMenu)
	 */

	public List<TypeOfService> getAll() {

		CriteriaQuery<TypeOfService> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(TypeOfService.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(TypeOfService.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final TypeOfServiceBean ejbProxy = this.sessionContext
				.getBusinessObject(TypeOfServiceBean.class);

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

				return String.valueOf(((TypeOfService) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private TypeOfService add = new TypeOfService();

	public TypeOfService getAdd() {
		return this.add;
	}

	public TypeOfService getAdded() {
		TypeOfService added = this.add;
		this.add = new TypeOfService();
		return added;
	}
}
