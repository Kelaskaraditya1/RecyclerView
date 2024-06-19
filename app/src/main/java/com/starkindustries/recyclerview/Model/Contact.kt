package com.starkindustries.recyclerview.Model
class Contact
{
    var profileImage:Int=0
    lateinit var name:String
    lateinit var contactNo:String
    constructor(profiileImage_:Int,name_:String,contactNo_:String)
    {
        this.profileImage=profiileImage_
        this.name=name_
        this.contactNo=contactNo_
    }
    constructor(name_:String,contactNo_: String)
    {
        this.name=name_
        this.contactNo=contactNo_
    }
    constructor()
    {}
}