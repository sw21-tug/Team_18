package com.example.saveup.ui.form

import com.example.saveup.ProfileActivity.Companion.sortListBy


class FormData (
    val id: String,
    val type: String,
    val date: String,
    val description: String,
    val amount: Int,
    val tags: String
    ) : Comparable<Any> {
    override fun compareTo(other: Any): Int {
        when (sortListBy){
            "Description Ascending" -> return sortByDescription(other)
            "Description Descending" -> return sortByDescription(other)
            "Amount Ascending" -> return sortByAmount(other)
            "Amount Descending" -> return sortByAmount(other)
        }
        return 0
    }

    private fun sortByDescription (other: Any): Int {
        val formData = other as FormData
        if (formData.description == description)
            return 0
        else if (description == "")
            return 1
        else if (formData.description == "")
            return -1
        else
        {
            for (i in description.indices)
            {
                if (i >= formData.description.length)
                    return 1
                if (description[i] < formData.description[i])
                    return -1
                else
                    return 1
            }
        }
        return 0
    }

    private fun sortByAmount (other: Any): Int {
        val formData = other as FormData
        if (formData.amount > amount)
            return -1
        else if (formData.amount < amount)
            return 1
        return 0
    }
}