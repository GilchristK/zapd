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

import java.util.logging.*;
import org.zapd.model.Registration;

/**
 * Backing bean for Registration entities.
 * <p/>
 This class provides CRUD functionality for all Registration entities.
 It focuses purely on Java EE 6 standards (e.g.
 <tt>&#64;ConversationScoped</tt> for state management,
 * <tt>PersistenceContext</tt> for persistence, <tt>CriteriaBuilder</tt> for
 * searches) rather than introducing a CRUD framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class RegistrationBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(RegistrationBean.class.getName());

	/*
	 * Support creating and retrieving Registration entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private Registration registration;

	public Registration getRegistration() {
		return this.registration;
	}

	public void setRegistration(
			Registration registration) {
		this.registration = registration;
	}

	@Inject
	private Conversation conversation;

	@PersistenceContext(unitName = "zapdPU", type = PersistenceContextType.EXTENDED)
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
			this.registration = this.example;
		} else {
			this.registration = findById(getId());
		}
	}

	public Registration findById(Long id) {

		return this.entityManager.find(Registration.class, id);
	}

	/*
	 * Support updating and deleting Registration entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.registration);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.registration);
				return "view?faces-redirect=true&id="
						+ this.registration.getId();
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
			Registration deletableEntity = findById(getId());
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
	 * Support searching Registration entities with pagination
	 */

	private int page;
	private long count;
	private List<Registration> pageItems;

	private Registration example = new Registration();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public Registration getExample() {
		return this.example;
	}

	public void setExample(Registration example) {
		this.example = example;
	}

	public String search() {
		this.page = 0;
		Boolean isTransient = this.conversation.isTransient();
		log.log(Level.INFO,"conversation is transiet?"+isTransient);
		this.conversation.end();
		return null;
	}

	public void paginate() {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();

		// Populate this.count

		CriteriaQuery<Long> countCriteria = builder.createQuery(Long.class);
		Root<Registration> root = countCriteria
				.from(Registration.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<Registration> criteria = builder
				.createQuery(Registration.class);
		root = criteria.from(Registration.class);
		TypedQuery<Registration> query = this.entityManager
				.createQuery(criteria.select(root).where(
						getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<Registration> root) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicatesList = new ArrayList<Predicate>();

		String firstname = this.example.getFirstname();
		if (firstname != null && !"".equals(firstname)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("firstname")),
					'%' + firstname.toLowerCase() + '%'));
		}
		String surname = this.example.getSurname();
		if (surname != null && !"".equals(surname)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("surname")),
					'%' + surname.toLowerCase() + '%'));
		}
		String dateOfBirth = this.example.getDateOfBirth();
		if (dateOfBirth != null && !"".equals(dateOfBirth)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("dateOfBirth")),
					'%' + dateOfBirth.toLowerCase() + '%'));
		}
		String nrc = this.example.getNrc();
		if (nrc != null && !"".equals(nrc)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("nrc")),
					'%' + nrc.toLowerCase() + '%'));
		}
		String sex = this.example.getSex();
		if (sex != null && !"".equals(sex)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("sex")),
					'%' + sex.toLowerCase() + '%'));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<Registration> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back Registration entities (e.g. from
	 * inside an HtmlSelectOneMenu)
	 */

	public List<Registration> getAll() {

		CriteriaQuery<Registration> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(Registration.class);
		return this.entityManager.createQuery(criteria.select(criteria.from(Registration.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final RegistrationBean ejbProxy = this.sessionContext
				.getBusinessObject(RegistrationBean.class);

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

				return String.valueOf(((Registration) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private Registration add = new Registration();

	public Registration getAdd() {
		return this.add;
	}

	public Registration getAdded() {
		Registration added = this.add;
		this.add = new Registration();
		return added;
	}
}
