package com.ivanmorgillo.arrowktplayground.lenses

fun main() {

    /**
     * File AccountExample.kt contains the data classes that model
     * this user Account: Bank, ContactInfo with a couple of types,
     * a home Address. The usual stuff.
     *
     * This is our bogus Account:
     */
    val account = Account(
        name = "Frank",
        bank = Bank("SuperBank", "qwertyuio"),
        contacts = ContactInfo(
            phone = Phone(
                Mobile("+39", "123456789"),
                Home("+39", "987654321")
            ),
            address = Address("In the middle of nowhere")
        )
    )
    println(account)

    /**
     * I want to change the mobile phone number from "123456789" to "000000"
     * It's gonna take a few nested .copy calls:
     */
    val updatedAccount = account.copy(
        contacts = account.contacts.copy(
            phone = account.contacts.phone.copy(
                mobile = account.contacts.phone.mobile.copy(number = "000000")
            )
        )
    )

    println(updatedAccount)

    /**
     * Now I want to do the same using a lens:
     */
    val lensUpdatedAccount = Account.contacts.phone.mobile.number.modify(account) { "000000" }

    println(lensUpdatedAccount)

    /**
     * Yep, I know, right? :)
     * Congratulations! You now know what a lens is:
     * a way to get rid of the pain on nested data classes.
     */
}
