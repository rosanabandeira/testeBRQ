
package br.com.rosana.testebrq.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PersonResponse implements Parcelable {

    @Expose
    @SerializedName("people")
    private List<Person> people;

    protected PersonResponse(Parcel in) {
        people = in.createTypedArrayList(Person.CREATOR);
    }

    public static final Creator<PersonResponse> CREATOR = new Creator<PersonResponse>() {
        @Override
        public PersonResponse createFromParcel(Parcel in) {
            return new PersonResponse(in);
        }

        @Override
        public PersonResponse[] newArray(int size) {
            return new PersonResponse[size];
        }
    };

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(people);
    }
}
