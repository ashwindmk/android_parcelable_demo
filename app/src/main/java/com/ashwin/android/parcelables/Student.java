package com.ashwin.android.parcelables;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.util.Arrays;

public class Student implements Parcelable {
    long id;
    String name;
    int age;
    double points;
    boolean married;
    Address address;
    int[] arr;

    public Student(long id, String name, int age, double points, boolean married, Address address, final int[] arr) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.points = points;
        this.married = married;
        this.address = address;
        this.arr = arr;
    }

    protected Student(Parcel in) {
        id = in.readLong();
        name = in.readString();
        age = in.readInt();
        points = in.readDouble();
        married = in.readByte() != 0;
        address = in.readParcelable(Address.class.getClassLoader());
        arr = in.createIntArray();
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            Log.d("parcelables", "Creating Student from Parcel");
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        Log.d("parcelables", "Writing Student to Parcel");
        dest.writeLong(id);
        dest.writeString(name);
        dest.writeInt(age);
        dest.writeDouble(points);
        dest.writeByte((byte) (married ? 1 : 0));
        dest.writeParcelable(address, flags);
        dest.writeIntArray(arr);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", points=" + points +
                ", married=" + married +
                ", " + address +
                ", arr: " + Arrays.toString(arr) +
                '}';
    }
}
