
package br.com.rosana.testebrq.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Person implements Parcelable {

    @Expose
    @SerializedName("bio")
    private String bio;

    @Expose
    @SerializedName("birthday")
    private String birthday;

    @Expose
    @SerializedName("id")
    private String id;

    @Expose
    @SerializedName("image")
    private String image;

    @Expose
    @SerializedName("name")
    private String name;

    public Person() {
    }

    public Person(String bio, String birthday, String id, String image, String name) {
        this.bio = bio;
        this.birthday = birthday;
        this.id = id;
        this.image = image;
        this.name = name;
    }

    protected Person(Parcel in) {
        bio = in.readString();
        birthday = in.readString();
        id = in.readString();
        image = in.readString();
        name = in.readString();
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(bio);
        dest.writeString(birthday);
        dest.writeString(id);
        dest.writeString(image);
        dest.writeString(name);
    }
}
