package com.example.proyecto_movipet

import android.content.ContentValues
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import com.example.proyecto_movipet.databinding.ConfirmarFotoBinding
import java.io.File
import java.io.OutputStream
import java.util.*

// Tiene que aparecer esto en tu codigo //

class ConfirmarFotoMascota : AppCompatActivity() {

    private lateinit var binding: ConfirmarFotoBinding
    private lateinit var file: File

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ConfirmarFotoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnFoto.setOnClickListener {
            verificarPermisoCamara()
        }

        binding.btnGaleria.setOnClickListener {
            verificarPermisoAlmacenamiento()
        }

        binding.btnGuardar.setOnClickListener {
            guardarEnGaleria()
        }

        binding.btnContinuar.setOnClickListener(){
            val intent = Intent(this, ConfirmacionRegistro::class.java)
            startActivity(intent)
        }
    }

    private val abrirCamara =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val bitmap = obtenerBitMap()
                val img = findViewById<ImageView>(R.id.img)
                val matrix = Matrix()
                matrix.postRotate(90f)
                val rotatedBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.width, bitmap.height, matrix, true)
                img.setImageBitmap(rotatedBitmap)
            }
        }

    private val escogerFoto = registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { result ->
        if (result!=null) {
            val img = findViewById<ImageView>(R.id.img)
            img.setImageURI(result)
            Log.i ("registro_mascota","Imagen seleccionada")
        }
        else{
            Toast.makeText(this, "No se seleccionó ninguna imagen", Toast.LENGTH_LONG).show()
            Log.i ("registro_mascota","No se seleccionó ninguna imagen")
        }
    }

    private fun createPhotoFile() {
        val directorio = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        file = File.createTempFile("IMG_${System.currentTimeMillis()}_", ".jpg", directorio)
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    private fun guardarEnGaleria() {
        val contenedor = crearContenedor()
        val uri = guardarImagen(contenedor)
        limpiarContenedor(contenedor, uri)
        Toast.makeText(this,"Imagen guardada en la galeria",Toast.LENGTH_LONG).show()
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    private fun crearContenedor(): ContentValues {

        val nombreArchivo = file.name
        val tipoArchivo = "image/jpg"
        return ContentValues().apply {
            put(MediaStore.MediaColumns.DISPLAY_NAME, nombreArchivo)
            put(MediaStore.Files.FileColumns.MIME_TYPE, tipoArchivo)
            put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_PICTURES)
            put(MediaStore.MediaColumns.IS_PENDING, 1)
        }
    }

    private fun guardarImagen(contenedor: ContentValues): Uri {
        var outputStream: OutputStream?
        var uri: Uri?

        application.contentResolver.also { resolver ->
            uri = resolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contenedor)
            outputStream = resolver.openOutputStream(uri!!)
        }
        outputStream?.use { output ->
            obtenerBitMap().compress(Bitmap.CompressFormat.JPEG, 100, output)
        }
        return uri!!
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    private fun limpiarContenedor(contenedor: ContentValues, uri: Uri) {
        contenedor.clear()
        contenedor.put(MediaStore.MediaColumns.IS_PENDING, 0)
        contentResolver.update(uri, contenedor, null, null)
    }

    private fun obtenerBitMap(): Bitmap {
        return BitmapFactory.decodeFile(file.toString())
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    private fun verificarPermisoCamara() {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA)
            != android.content.pm.PackageManager.PERMISSION_GRANTED) {
            pedirPermisoCamara()
        }else {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE).also {
                it.resolveActivity(packageManager)?.also { _ ->
                    createPhotoFile()
                    val photoURI: Uri = FileProvider.getUriForFile(
                        this,
                        BuildConfig.APPLICATION_ID + ".fileprovider", file
                    )
                    it.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
                }
            }
            abrirCamara.launch(intent)
        }
    }
    private fun pedirPermisoCamara(){
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.CAMERA)){
            Toast.makeText(this, "Permisos rechazados", Toast.LENGTH_LONG).show()
        }
        else{
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA), 1)
        }
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    private fun verificarPermisoAlmacenamiento(){
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
            != android.content.pm.PackageManager.PERMISSION_GRANTED){
            pedirPermisoAlmacenamiento()
        }else{
            escogerFoto.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
        }
    }

    private fun pedirPermisoAlmacenamiento() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)){
            Toast.makeText(this, "Permisos rechazados", Toast.LENGTH_LONG).show()
        }
        else{
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE), 2)
        }
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1) {
            if (grantResults.isNotEmpty() && grantResults[0] == android.content.pm.PackageManager.PERMISSION_GRANTED) {
                val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE).also {
                    it.resolveActivity(packageManager)?.also { _ ->
                        createPhotoFile()
                        val photoURI: Uri = FileProvider.getUriForFile(
                            this,
                            BuildConfig.APPLICATION_ID + ".fileprovider", file
                        )
                        it.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
                    }
                }
                abrirCamara.launch(intent)
            } else {
                Toast.makeText(this, "Permisos rechazados por primera vez", Toast.LENGTH_LONG)
                    .show()
            }
        }
        else if (requestCode == 2){
            if (grantResults.isNotEmpty() && grantResults[0] == android.content.pm.PackageManager.PERMISSION_GRANTED) {
                escogerFoto.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
            } else {
                Toast.makeText(this, "Permisos rechazados por primera vez", Toast.LENGTH_LONG).show()
            }
        }
    }
}