package ua.donordp.model;

import javax.persistence.*;

@Entity
@Table(name = "bids")
public class Bid {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "BID_USER_NAME")
    private String bidUserName;

    @Column(name = "BID_HOSPITAL")
    private String bidHospital;

    @Column(name = "BID_CONTACTS")
    private String bidContactNumber;

    @Column(name = "BID_QUANTITY")
    private String bidQuantity;

    @Column(name = "BID_INFO")
    private String bidInfo;

    @Column(name = "BID_GROUP")
    private String bidGroup;

    @Column(name = "BID_COMMENTS")
    private String bidComments;

    @Column(name = "BID_DATE")
    private String bidDate;

    @Column(name = "BID_RECIPIENT_BIRTH_DATE")
    private String recipientBirthDate;

    @Column(name = "BID_EMAIL")
    private String email;

    @Column(name = "BID_TYPE")
    private String bidType;

    @Column(name = "BID_RHESUS_FACTOR")
    private String bidRhesusFactor;

    @Column(name = "BID_CONTACT_NAME")
    private String bidContactName;

    @Column(name = "BID_TIME")
    private String bidTime;

    public String getBidTime() {
        return bidTime;
    }

    public void setBidTime(String bidTime) {
        this.bidTime = bidTime;
    }

    public String getBidDate() {
        return bidDate;
    }

    public void setBidDate(String bidDate) {
        this.bidDate = bidDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBidUserName() {
        return bidUserName;
    }

    public void setBidUserName(String bidUserName) {
        this.bidUserName = bidUserName;
    }

    public String getBidHospital() {
        return bidHospital;
    }

    public void setBidHospital(String bidHospital) {
        this.bidHospital = bidHospital;
    }

    public String getBidQuantity() {
        return bidQuantity;
    }

    public void setBidQuantity(String bidQuantity) {
        this.bidQuantity = bidQuantity;
    }

    public String getBidInfo() {
        return bidInfo;
    }

    public void setBidInfo(String bidInfo) {
        this.bidInfo = bidInfo;
    }

    public String getBidGroup() {
        return bidGroup;
    }

    public void setBidGroup(String bidGroup) {
        this.bidGroup = bidGroup;
    }

    public String getBidComments() {
        return bidComments;
    }

    public void setBidComments(String bidComments) {
        this.bidComments = bidComments;
    }

    public String getBidContactNumber() {
        return bidContactNumber;
    }

    public void setBidContactNumber(String bidContactNumber) {
        this.bidContactNumber = bidContactNumber;
    }

    public String getRecipientBirthDate() {
        return recipientBirthDate;
    }

    public void setRecipientBirthDate(String recipientBirthDate) {
        this.recipientBirthDate = recipientBirthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBidType() {
        return bidType;
    }

    public void setBidType(String bidType) {
        this.bidType = bidType;
    }

    public String getBidRhesusFactor() {
        return bidRhesusFactor;
    }

    public void setBidRhesusFactor(String bidRhesusFactor) {
        this.bidRhesusFactor = bidRhesusFactor;
    }

    public String getBidContactName() {
        return bidContactName;
    }

    public void setBidContactName(String bidContactName) {
        this.bidContactName = bidContactName;
    }

    @Override
    public String toString() {
        return "Bid{" +
                "id=" + id +
                ", bidUserName='" + bidUserName + '\'' +
                ", bidHospital='" + bidHospital + '\'' +
                ", bidContactNumber='" + bidContactNumber + '\'' +
                ", bidQuantity='" + bidQuantity + '\'' +
                ", bidInfo='" + bidInfo + '\'' +
                ", bidGroup='" + bidGroup + '\'' +
                ", bidComments='" + bidComments + '\'' +
                ", bidDate='" + bidDate + '\'' +
                ", recipientBirthDate='" + recipientBirthDate + '\'' +
                ", email='" + email + '\'' +
                ", bidType='" + bidType + '\'' +
                ", bidRhesusFactor='" + bidRhesusFactor + '\'' +
                ", bidContactName='" + bidContactName + '\'' +
                '}';
    }
}