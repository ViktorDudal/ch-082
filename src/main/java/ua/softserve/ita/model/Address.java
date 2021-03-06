package ua.softserve.ita.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "address")
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private long addressId;

    @Column(name = "country",nullable = false,length = 20)
    private String country;

    @Column(name = "city",nullable = false,length = 15)
    private String city;

    @Column(name = "street",length = 30)
    private String street;

    @Column(name = "building",length = 5)
    private String building;

    @Column(name = "apartment",length = 5)
    private String apartment;

    @Column(name = "zip_code")
    private Integer zipCode;

    @OneToOne(mappedBy = "address")
    private Person person;

    @OneToOne(mappedBy = "address")
    private Company company;

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return addressId == address.addressId &&
                country.equals(address.country) &&
                city.equals(address.city) &&
                Objects.equals(street, address.street) &&
                Objects.equals(building, address.building) &&
                Objects.equals(apartment, address.apartment) &&
                Objects.equals(zipCode, address.zipCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressId, country, city, street, building, apartment, zipCode);
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", building='" + building + '\'' +
                ", apartment='" + apartment + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }

}
