package com.example.submisi.model

import android.os.Parcel
import android.os.Parcelable

//TODO 1. CREATE MODEL
data class FootbalClub(val nameFootbal: String?, val nameImage: Int, val nameDesc: String?) :
    Parcelable {
    constructor(source: Parcel) : this(
        source.readString(),
        source.readValue(Int::class.java.classLoader) as Int,
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(nameFootbal)
        writeValue(nameImage)
        writeString(nameDesc)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<FootbalClub> = object : Parcelable.Creator<FootbalClub> {
            override fun createFromParcel(source: Parcel): FootbalClub = FootbalClub(source)
            override fun newArray(size: Int): Array<FootbalClub?> = arrayOfNulls(size)
        }
    }
}