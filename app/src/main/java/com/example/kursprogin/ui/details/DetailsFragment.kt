package com.example.kursprogin.ui.details

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.kursprogin.data.room.DbRoom
import com.example.kursprogin.data.room.dto.FavouriteDto
import com.example.kursprogin.databinding.FragmentDetailsBinding
import com.example.kursprogin.myRef
import com.example.kursprogin.ui.home.DataFromList
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.squareup.picasso.Picasso
import kotlinx.coroutines.runBlocking

class DetailsFragment : Fragment() {


    private lateinit var dbbbb: DbRoom
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private var idDisk: Int = 1
    private var nameDisk: String = "no Name"
    private var imageDisk: String = "https://firebasestorage.googleapis.com/v0/b/kursovaia-f942a.appspot.com/o/1.1.jpg?alt=media&token=1fb6724e-2bb9-415f-b7af-0be0ffd9d2e6"
    private var tmpSer = false


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)

        dbbbb = DbRoom(requireContext())
        val b = arguments
        idDisk = b!!.getInt("idDisk")

        binding.textViewName.text = idDisk.toString()
        readDb()

        binding.imageViewB.setOnClickListener {
            tmpSer = !tmpSer
            runBlocking {
                if (tmpSer) {
                    dbbbb.getFavouriteDao().saveFavourite(
                        FavouriteDto(
                            idDisk,
                            binding.textViewName.text.toString(),
                            imageDisk
                        )
                    )
                    Toast.makeText(context,"added",Toast.LENGTH_SHORT).show()
                }else{
                    dbbbb.getFavouriteDao().deleteFavourite(
                        FavouriteDto(
                            idDisk,
                            binding.textViewName.text.toString(),
                            imageDisk
                        )
                    )
                    Toast.makeText(context,"deleted",Toast.LENGTH_SHORT).show()
                }
            }
        }

        return binding.root
    }


    fun readDb() {

        val tmp = mutableListOf<DataFromList>()
        myRef.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                tmp.clear()
                val disksCount = dataSnapshot.child("Disk").children
                for (i in disksCount) {
                    if (i.key.toString() == idDisk.toString()) {
                        binding.textViewName.text = i.child("Name").value.toString()
                        nameDisk = i.child("Name").value.toString()
                        binding.textViewFF.text = i.child("FormFactor").value.toString()
                        binding.textViewSize.text = i.child("Size").value.toString()
                        binding.textViewType.text = i.child("Type").value.toString()
                        binding.textViewWeight.text = i.child("Weight").value.toString()
                        binding.textViewSpeed.text = i.child("Speed").value.toString()
                        binding.textViewDes.text = i.child("Description").value.toString()
                        Picasso.with(requireContext())
                            .load(i.child("firstUrl").value.toString())
                            .into(binding.imageView)
                        imageDisk = i.child("firstUrl").value.toString()

                        runBlocking {

                            var tmpDto = listOf<FavouriteDto>()
                            tmpDto = dbbbb.getFavouriteDao().getSavedFavourites()
                            for (i in tmpDto){
                                if (nameDisk == i.nameDisk){
                                    binding.imageViewB.setChecked(true)
                                    tmpSer = true
                                }
                            }
                        }
                    }


                    Log.d(
                        "TAG1",
                        "${i.child("firstUrl").value.toString()} ${i.child("Name").value.toString()} ${i.key.toString()}"
                    )
                    tmp.add(
                        DataFromList(
                            i.child("firstUrl").value.toString(),
                            i.child("Name").value.toString(),
                            i.key.toString().toInt()
                        )
                    )
                }
                Log.d("TAG1", "Value is: ${tmp.toString()}")

            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("TAG1", "Failed to read value.", error.toException())
            }
        })
    }


}