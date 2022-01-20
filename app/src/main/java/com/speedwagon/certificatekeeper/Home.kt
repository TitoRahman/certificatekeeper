package com.speedwagon.certificatekeeper

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.TextView
import androidx.cardview.widget.CardView
import java.io.File
import android.os.StatFs
import android.provider.MediaStore
import android.view.View
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.graphics.convertTo
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.jar.Manifest
import kotlin.contracts.Returns
import kotlin.math.round

class Home : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: RecentlyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        init()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter


        // TextView to show information
        val mTextView= findViewById<TextView>(R.id.internalmemori)


        // Fetching internal memory information
        val iPath: File = Environment.getDataDirectory()
        val iStat = StatFs(iPath.path)
        val iBlockSize = iStat.blockSizeLong
        val iAvailableBlocks = iStat.availableBlocksLong
        val iTotalBlocks = iStat.blockCountLong
        val iAvailableSpace = formatSize(iAvailableBlocks * iBlockSize)
        val iTotalSpace = formatSize(iTotalBlocks * iBlockSize)

        // Displaying the fetched info
        mTextView.text = "$iAvailableSpace \\ $iTotalSpace"

        // TextView to show information for external memory
        val eTextView= findViewById<TextView>(R.id.sdcard)

        val sPath: File? = Environment.getExternalStorageDirectory()
        val statFs = StatFs(sPath?.path)
        val blockSize = statFs.blockSizeLong
        val totalSize = statFs.blockCountLong * blockSize
        val availableSize = formatSize(statFs.availableBlocksLong * blockSize)
        val freeSize = formatSize(statFs.freeBlocksLong * blockSize)

        //  Displaying the fetched info(for external memory)
        eTextView.text= "$availableSize \\ $freeSize"
    }

    private fun formatSize(size: Long): String? {
        var size = size
        var suffix: String? = null
        if (size >= 1024) {
            suffix = "KB"
            size /= 1024
            if (size >= 1024) {
                suffix = "MB"
                size /= 1024
                if (size >= 1024) {
                    suffix = "GB"
                    size /= 1024
                }
            }
        }

        val resultBuffer = StringBuilder(java.lang.Long.toString(size))
        var commaOffset = resultBuffer.length - 3
        while (commaOffset > 0) {
            resultBuffer.insert(commaOffset, ',')
            commaOffset -= 3}
        if (suffix != null) resultBuffer.append(suffix)
        return resultBuffer.toString()
    }

    //menu to profile
    fun Openprofile(view: View) {
        var intentprofile = Intent(this,Profile::class.java)
        startActivity(intentprofile)
    }


    fun init(){
        recyclerView = findViewById(R.id.recently)

        var data = arrayListOf<recentlyfile>()
        data.add(recentlyfile(R.drawable.dokumen, "File 1"))
        data.add(recentlyfile(R.drawable.dokumen, "File 2"))
        data.add(recentlyfile(R.drawable.dokumen, "File 3"))
        adapter = RecentlyAdapter(data)
    }

    fun opencamera(view: View){
        camerapermission()
        val intent = Intent("android.media.action.IMAGE_CAPTURE")
        startActivity(intent)
    }

    fun camerapermission(){
        var permission = arrayOf(android.Manifest.permission.CAMERA)
        var needpermission : ArrayList<String> = ArrayList()
        for (i in permission){
            if(ContextCompat.checkSelfPermission(this@Home,i)!= PackageManager.PERMISSION_GRANTED){
                needpermission.add(i)
            }
        }
        if (!needpermission.isEmpty()){
            ActivityCompat.requestPermissions(this, needpermission.toArray(arrayOfNulls(needpermission.size)),123)
        }
    }

}