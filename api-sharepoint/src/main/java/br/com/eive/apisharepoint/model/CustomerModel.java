package br.com.eive.apisharepoint.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "customer")
public class CustomerModel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean usesNewIntegration;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Boolean useVpn;

    @Column(length = 1, nullable = false)
    private Character tier;

    @Column(length = 4000)
    private String notes;

    @Column(length = 4000)
    private String dbInfo;

    @Column(length = 36)
    private String segment;

    @Column(length = 80, nullable = false)
    private String responsible;

//    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "customer")
//    private List<ContactModel> contacts = new ArrayList<>();
//
//    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "customer")
//    private List<ServerModel> server = new ArrayList<>();
//
//    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "customer")
//    private List<ProductModel> products = new ArrayList<>();

    public CustomerModel(){
    }

    public CustomerModel(String name, String notes, String dbInfo, Boolean usesVpn, Boolean usesNewIntegration,
                    Character tier, String segment, String responsible) {
        this.name = name;
        this.notes = notes;
        this.dbInfo = dbInfo;
        this.useVpn = usesVpn;
        this.usesNewIntegration = usesNewIntegration;
        this.tier = tier;
        this.segment = segment;
        this.responsible = responsible;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CustomerModel that = (CustomerModel) obj;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNotes() {
        return notes;
    }

    public String getDbInfo() {
        return dbInfo;
    }

    public Boolean getUseVpn() {
        return useVpn;
    }

    public Boolean getUsesNewIntegration() {
        return usesNewIntegration;
    }

    public Character getTier() {
        return tier;
    }

    public String getSegment() {
        return segment;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsesNewIntegration(boolean usesNewIntegration) {
        this.usesNewIntegration = usesNewIntegration;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUseVpn(boolean useVpn) {
        this.useVpn = useVpn;
    }

    public void setTier(Character tier) {
        this.tier = tier;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setDbInfo(String dbInfo) {
        this.dbInfo = dbInfo;
    }

    public void setSegment(String segment) {
        this.segment = segment;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }
}
