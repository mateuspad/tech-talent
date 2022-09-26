package com.example.tech_talent.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Projects implements Parcelable {
    private String id;
    private String title;
    private String description;
    private String startDate;
    private String expectedEndDate;
    private String amountPeople;

    public Projects() {
    }

    public Projects(String id, String title, String description, String start_date, String expected_end_date, String amount_people) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.startDate = start_date;
        this.expectedEndDate = expected_end_date;
        this.amountPeople = amount_people;
    }

    protected Projects(Parcel in) {
        id = in.readString();
        title = in.readString();
        description = in.readString();
        startDate = in.readString();
        expectedEndDate = in.readString();
        amountPeople = in.readString();
    }

    public static final Creator<Projects> CREATOR = new Creator<Projects>() {
        @Override
        public Projects createFromParcel(Parcel in) {
            return new Projects(in);
        }

        @Override
        public Projects[] newArray(int size) {
            return new Projects[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStart_date() {
        return startDate;
    }

    public void setStart_date(String start_date) {
        this.startDate = start_date;
    }

    public String getExpected_end_date() {
        return expectedEndDate;
    }

    public void setExpected_end_date(String expected_end_date) {
        this.expectedEndDate = expected_end_date;
    }

    public String getAmount_people() {
        return amountPeople;
    }

    public void setAmount_people(String amount_people) {
        this.amountPeople = amount_people;
    }

    @Override
    public String toString() {
        return "Projetos{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", start_date='" + startDate + '\'' +
                ", expected_end_date='" + expectedEndDate + '\'' +
                ", amount_people='" + amountPeople + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(title);
        parcel.writeString(description);
        parcel.writeString(startDate);
        parcel.writeString(expectedEndDate);
        parcel.writeString(amountPeople);
    }
}
