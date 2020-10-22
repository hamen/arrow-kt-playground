package lenses

import arrow.optics.optics

@optics
data class Account(val name: String, val bank: Bank, val contacts: ContactInfo) {
    companion object
}

@optics
data class ContactInfo(val phone: Phone, val address: Address) {
    companion object
}

@optics
data class Phone(val mobile: Mobile, val home: Home) {
    companion object
}

@optics
data class Mobile(val prefix: String, val number: String) {
    companion object
}

data class Bank(val name: String, val accountNumber: String)
data class Home(val prefix: String, val home: String)
data class Address(val address: String)
