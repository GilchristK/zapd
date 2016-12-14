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

import org.zapd.model.TypeOfCase;

/**
 * Backing bean for TypeOfCase entities.
 * <p/>
 * This class provides CRUD functionality for all TypeOfCase entities. It
 * focuses purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt>
 * for state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD
 * framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class TypeOfCaseBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving TypeOfCase entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private TypeOfCase typeOfCase;

	public TypeOfCase getTypeOfCase() {
		return this.typeOfCase;
	}

	public void setTypeOfCase(TypeOfCase typeOfCase) {
		this.typeOfCase = typeOfCase;
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
			this.typeOfCase = this.example;
		} else {
			this.typeOfCase = findById(getId());
		}
	}

	public TypeOfCase findById(Long id) {

		return this.entityManager.find(TypeOfCase.class, id);
	}

	/*
	 * Support updating and deleting TypeOfCase entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.typeOfCase);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.typeOfCase);
				return "view?faces-redirect=true&id=" + this.typeOfCase.getId();
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
			TypeOfCase deletableEntity = findById(getId());

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
	 * Support searching TypeOfCase entities with pagination
	 */

	private int page;
	private long count;
	private List<TypeOfCase> pageItems;

	private TypeOfCase example = new TypeOfCase();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public TypeOfCase getExample() {
		return this.example;
	}

	public void setExample(TypeOfCase example) {
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
		Root<TypeOfCase> root = countCriteria.from(TypeOfCase.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<TypeOfCase> criteria = builder
				.createQuery(TypeOfCase.class);
		root = criteria.from(TypeOfCase.class);
		TypedQuery<TypeOfCase> query = this.entityManager.createQuery(criteria
				.select(root).where(getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<TypeOfCase> root) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicatesList = new ArrayList<Predicate>();

		String typeOfCase = this.example.getTypeOfCase();
		if (typeOfCase != null && !"".equals(typeOfCase)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("typeOfCase")),
					'%' + typeOfCase.toLowerCase() + '%'));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<TypeOfCase> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back TypeOfCase entities (e.g. from inside an
	 * HtmlSelectOneMenu)
	 */

	public List<TypeOfCase> getAll() {

		CriteriaQuery<TypeOfCase> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(TypeOfCase.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(TypeOfCase.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final TypeOfCaseBean ejbProxy = this.sessionContext
				.getBusinessObject(TypeOfCaseBean.class);

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

				return String.valueOf(((TypeOfCase) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private TypeOfCase add = new TypeOfCase();

	public TypeOfCase getAdd() {
		return this.add;
	}

	public TypeOfCase getAdded() {
		TypeOfCase added = this.add;
		this.add = new TypeOfCase();
		return added;
	}
}
