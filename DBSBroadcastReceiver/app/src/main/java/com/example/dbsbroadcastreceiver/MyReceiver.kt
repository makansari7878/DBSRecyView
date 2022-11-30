package com.example.dbsbroadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.SmsMessage
import android.util.Log
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(ctx: Context?, intent: Intent?) {
       Toast.makeText(ctx, "sms received.... ", Toast.LENGTH_LONG).show()

        var bundle = intent?.extras
        if(bundle != null){

            var pdusObj = bundle["pdus"] as Array<Any>

            for( i in pdusObj.indices){
                val currentMessage = SmsMessage.createFromPdu(pdusObj[i] as ByteArray)

                val myMessage = currentMessage.displayMessageBody
                val receiverPh = currentMessage.originatingAddress

                Toast.makeText(ctx,"message is $myMessage and sender is : $receiverPh",Toast.LENGTH_LONG).show()

                Log.i("mytag", "message is $myMessage and sender is : $receiverPh")
            }




        }




       /* var i = Intent(ctx, SecondAcrivity::class.java)
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        ctx?.startActivity(i)*/
    }
}