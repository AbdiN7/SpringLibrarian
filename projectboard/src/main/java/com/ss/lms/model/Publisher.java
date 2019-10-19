package com.ss.lms.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "tbl_publisher")
public class Publisher implements Serializable {
 
	private static final long serialVersionUID = 7430604422769898356L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisherId")
    private Integer publisherId;

    private String publisherName;

    private String publisherAddress;
    private String publisherPhone;

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getPublisherAddress() {
        return publisherAddress;
    }

    public void setPublisherAddress(String publisherAddress) {
        this.publisherAddress = publisherAddress;
    }

    public String getPublisherPhone() {
        return publisherPhone;
    }

    public void setPublisherPhone(String publisherPhone) {
        this.publisherPhone = publisherPhone;
    }
}
