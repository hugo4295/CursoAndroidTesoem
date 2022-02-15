package Objetos;

import android.os.Parcel;
import android.os.Parcelable;

public class Datos implements Parcelable{

    String nombre;
    int edad;
    String correo;

    public Datos() {
        this.nombre="";
        this.edad=0;
        this.correo="";
    }

    public Datos(String nombre, int edad, String correo) {
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
    }

    protected Datos(Parcel in) {
        nombre = in.readString();
        edad = in.readInt();
        correo = in.readString();
    }

    public static final Creator<Datos> CREATOR = new Creator<Datos>() {
        @Override
        public Datos createFromParcel(Parcel in) {
            return new Datos(in);
        }

        @Override
        public Datos[] newArray(int size) {
            return new Datos[size];
        }
    };

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nombre);
        parcel.writeInt(edad);
        parcel.writeString(correo);
    }
}
