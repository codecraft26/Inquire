package dev.aman.inquire.individual.data

import dev.aman.inquire.R
import dev.aman.inquire.individual.model.Inquire

class DataSource() {
    fun getData():List<Inquire>{
        return listOf<Inquire>(
            Inquire("Aman", "Kumar", R.drawable.ic_about),
            Inquire("Aman", "Kumar", R.drawable.ic_about),
            Inquire("Aman", "Kumar", R.drawable.ic_about),
            Inquire("Aman", "Kumar", R.drawable.ic_about),
            Inquire("Aman", "Kumar", R.drawable.ic_about),
            Inquire("Aman", "Kumar", R.drawable.ic_about),


            )

    }

}