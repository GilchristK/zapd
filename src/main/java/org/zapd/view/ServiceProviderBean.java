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

import org.zapd.model.ServiceProvider;

/**
 * Backing bean for ServiceProvider entities.
 * <p/>
 * This class provides CRUD functionality for all ServiceProvider entities. It
 * focuses purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt>
 * for state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD
 * framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class ServiceProviderBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving ServiceProvider entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private ServiceProvider serviceProvider;

	public ServiceProvider getServiceProvider() {
		return this.serviceProvider;
	}

	public void setServiceProvider(ServiceProvider serviceProvider) {
		this.serviceProvider = serviceProvider;
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
			this.serviceProvider = this.example;
		} else {
			this.serviceProvider = findById(getId());
		}
	}

	public ServiceProvider findById(Long id) {

		return this.entityManager.find(ServiceProvider.class, id);
	}

	/*
	 * Support updating and deleting ServiceProvider entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.serviceProvider);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.serviceProvider);
				return "view?faces-redirect=true&id="
						+ this.serviceProvider.getId();
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
			ServiceProvider deletableEntity = findById(getId());

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
	 * Support searching ServiceProvider entities with pagination
	 */

	private int page;
	private long count;
	private List<ServiceProvider> pageItems;

	private ServiceProvider example = new ServiceProvider();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public ServiceProvider getExample() {
		return this.example;
	}

	public void setExample(ServiceProvider example) {
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
		Root<ServiceProvider> root = countCriteria.from(ServiceProvider.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<ServiceProvider> criteria = builder
				.createQuery(ServiceProvider.class);
		root = criteria.from(ServiceProvider.class);
		TypedQuery<ServiceProvider> query = this.entityManager
				.createQuery(criteria.select(root).where(
						getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<ServiceProvider> root) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicatesList = new ArrayList<Predicate>();

		String nameOfServiceProvider = this.example.getNameOfServiceProvider();
		if (nameOfServiceProvider != null && !"".equals(nameOfServiceProvider)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("nameOfServiceProvider")),
					'%' + nameOfServiceProvider.toLowerCase() + '%'));
		}
		String postalAddress = this.example.getPostalAddress();
		if (postalAddress != null && !"".equals(postalAddress)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("postalAddress")),
					'%' + postalAddress.toLowerCase() + '%'));
		}
		String physicalAddress = this.example.getPhysicalAddress();
		if (physicalAddress != null && !"".equals(physicalAddress)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("physicalAddress")),
					'%' + physicalAddress.toLowerCase() + '%'));
		}
		String geographicalLocation = this.example.getGeographicalLocation();
		if (geographicalLocation != null && !"".equals(geographicalLocation)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("geographicalLocation")),
					'%' + geographicalLocation.toLowerCase() + '%'));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<ServiceProvider> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back ServiceProvider entities (e.g. from
	 * inside an HtmlSelectOneMenu)
	 */

	public List<ServiceProvider> getAll() {

		CriteriaQuery<ServiceProvider> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(ServiceProvider.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(ServiceProvider.class)))
				.getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final ServiceProviderBean ejbProxy = this.sessionContext
				.getBusinessObject(ServiceProviderBean.class);

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

				return String.valueOf(((ServiceProvider) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private ServiceProvider add = new ServiceProvider();

	public ServiceProvider getAdd() {
		return this.add;
	}

	public ServiceProvider getAdded() {
		ServiceProvider added = this.add;
		this.add = new ServiceProvider();
		return added;
	}
}
