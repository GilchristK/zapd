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

import org.zapd.model.ClientSkill;

/**
 * Backing bean for ClientSkill entities.
 * <p/>
 * This class provides CRUD functionality for all ClientSkill entities. It
 * focuses purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt>
 * for state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD
 * framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class ClientSkillBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving ClientSkill entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private ClientSkill clientSkill;

	public ClientSkill getClientSkill() {
		return this.clientSkill;
	}

	public void setClientSkill(ClientSkill clientSkill) {
		this.clientSkill = clientSkill;
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
			this.clientSkill = this.example;
		} else {
			this.clientSkill = findById(getId());
		}
	}

	public ClientSkill findById(Long id) {

		return this.entityManager.find(ClientSkill.class, id);
	}

	/*
	 * Support updating and deleting ClientSkill entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.clientSkill);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.clientSkill);
				return "view?faces-redirect=true&id="
						+ this.clientSkill.getId();
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
			ClientSkill deletableEntity = findById(getId());

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
	 * Support searching ClientSkill entities with pagination
	 */

	private int page;
	private long count;
	private List<ClientSkill> pageItems;

	private ClientSkill example = new ClientSkill();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public ClientSkill getExample() {
		return this.example;
	}

	public void setExample(ClientSkill example) {
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
		Root<ClientSkill> root = countCriteria.from(ClientSkill.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<ClientSkill> criteria = builder
				.createQuery(ClientSkill.class);
		root = criteria.from(ClientSkill.class);
		TypedQuery<ClientSkill> query = this.entityManager.createQuery(criteria
				.select(root).where(getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<ClientSkill> root) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicatesList = new ArrayList<Predicate>();

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<ClientSkill> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back ClientSkill entities (e.g. from inside
	 * an HtmlSelectOneMenu)
	 */

	public List<ClientSkill> getAll() {

		CriteriaQuery<ClientSkill> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(ClientSkill.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(ClientSkill.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final ClientSkillBean ejbProxy = this.sessionContext
				.getBusinessObject(ClientSkillBean.class);

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

				return String.valueOf(((ClientSkill) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private ClientSkill add = new ClientSkill();

	public ClientSkill getAdd() {
		return this.add;
	}

	public ClientSkill getAdded() {
		ClientSkill added = this.add;
		this.add = new ClientSkill();
		return added;
	}
}
