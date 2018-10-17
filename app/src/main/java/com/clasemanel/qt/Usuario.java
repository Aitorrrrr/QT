package com.clasemanel.qt;

import android.os.Parcel;
import android.os.Parcelable;

public class Usuario implements Parcelable
{
    private int ID;
    private String nombre;
    private String apellido;
    private String email;
    private int telefono;
    private String password;
    private boolean esVaron;

    public Usuario(int ID, String nombre, String apellido, String email, int telefono, String password, boolean esVaron)
    {
        this.ID = ID;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.password = password;
        this.esVaron = esVaron;
    }

    public int getID() {
        return ID;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getPassword() {
        return password;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public boolean isEsVaron() {
        return esVaron;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEsVaron(boolean esVaron) {
        this.esVaron = esVaron;
    }

    //Código de la parcelización
    protected Usuario(Parcel in) {
        ID = in.readInt();
        nombre = in.readString();
        apellido = in.readString();
        email = in.readString();
        telefono = in.readInt();
        password = in.readString();
        esVaron = in.readByte() != 0x00;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(ID);
        dest.writeString(nombre);
        dest.writeString(apellido);
        dest.writeString(email);
        dest.writeInt(telefono);
        dest.writeString(password);
        dest.writeByte((byte) (esVaron ? 0x01 : 0x00));
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Usuario> CREATOR = new Parcelable.Creator<Usuario>() {
        @Override
        public Usuario createFromParcel(Parcel in) {
            return new Usuario(in);
        }

        @Override
        public Usuario[] newArray(int size) {
            return new Usuario[size];
        }
    };
}
