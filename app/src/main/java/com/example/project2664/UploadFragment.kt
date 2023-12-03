package com.example.project2664

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.example.project2664.model.KaryaModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [UploadFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class UploadFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    fun newInstance(): UploadFragment {
        return UploadFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_upload, container, false)
        //instance
        lateinit var image: ImageView


        image = view.findViewById(R.id.imageUpKarya)
        val textId : EditText = view.findViewById(R.id.namaId)
        val textJudul1 : EditText = view.findViewById(R.id.namaKelas)
        val textNama : EditText = view.findViewById(R.id.namaSiswa)
        val btnAddImage : Button = view.findViewById(R.id.buttonAddImage)
        val btnSaveKarya : Button = view.findViewById(R.id.buttonUpKarya)

        //event saat buttom add(+) di klik
        btnAddImage.setOnClickListener {
            pickImageGalery()
        }

        //event saat button save di klik
        btnSaveKarya.setOnClickListener {
            //object class databasehelper
            val databaseHelper = DatabaseHelper(this)

            val id : Int = textId.id
            val name : String = textJudul1.text.toString().trim()
            val namasi : String = textNama.text.toString().trim()
            val bitmapDrawable : BitmapDrawable = image.drawable as BitmapDrawable
            val bitmap : Bitmap = bitmapDrawable.bitmap

            val karyaModel = KaryaModel(id,name,namasi,bitmap)
            databaseHelper.addKarya(karyaModel)
        }
        return view
    }

    private fun pickImageGalery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/"
        startActivityForResult(intent, Companion.IMAGE_REQUEST_CODE)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment UploadFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            UploadFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }

        const val IMAGE_REQUEST_CODE = 100
    }
}