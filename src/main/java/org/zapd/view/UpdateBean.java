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

import org.zapd.model.Update;

/**
 * Backing bean for Update entities.
 * <p/>
 * This class provides CRUD functionality for all Update entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD
 * framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class UpdateBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving Update entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private Update update;

	public Update getUpdate() {
		return this.update;
	}

	public void setUpdate(Update update) {
		this.update = update;
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
			this.update = this.example;
		} else {
			this.update = findById(getId());
		}
	}

	public Update findById(Long id) {

		return this.entityManager.find(Update.class, id);
	}

	/*
	 * Support updating and deleting Update entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.update);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.update);
				return "view?faces-redirect=true&id=" + this.update.getId();
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
			Update deletableEntity = findById(getId());

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
	 * Support searching Update entities with pagination
	 */

	private int page;
	private long count;
	private List<Update> pageItems;

	private Update example = new Update();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public Update getExample() {
		return this.example;
	}

	public void setExample(Update example) {
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
		Root<Update> root = countCriteria.from(Update.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<Update> criteria = builder.createQuery(Update.class);
		root = criteria.from(Update.class);
		TypedQuery<Update> query = this.entityManager.createQuery(criteria
				.select(root).where(getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<Update> root) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicatesList = new ArrayList<Predicate>();

		String dmisNumber = this.example.getDmisNumber();
		if (dmisNumber != null && !"".equals(dmisNumber)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("dmisNumber")),
					'%' + dmisNumber.toLowerCase() + '%'));
		}
		String surname = this.example.getSurname();
		if (surname != null && !"".equals(surname)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("surname")),
					'%' + surname.toLowerCase() + '%'));
		}
		String otherNames = this.example.getOtherNames();
		if (otherNames != null && !"".equals(otherNames)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("otherNames")),
					'%' + otherNames.toLowerCase() + '%'));
		}
		String identity = this.example.getIdentity();
		if (identity != null && !"".equals(identity)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("identity")),
					'%' + identity.toLowerCase() + '%'));
		}
		String typeOfUpdate = this.example.getTypeOfUpdate();
		if (typeOfUpdate != null && !"".equals(typeOfUpdate)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("typeOfUpdate")),
					'%' + typeOfUpdate.toLowerCase() + '%'));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<Update> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back Update entities (e.g. from inside an
	 * HtmlSelectOneMenu)
	 */

	public List<Update> getAll() {

		CriteriaQuery<Update> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(Update.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(Update.class))).getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final UpdateBean ejbProxy = this.sessionContext
				.getBusinessObject(UpdateBean.class);

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

				return String.valueOf(((Update) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private Update add = new Update();

	public Update getAdd() {
		return this.add;
	}

	public Update getAdded() {
		Update added = this.add;
		this.add = new Update();
		return added;
	}
}
