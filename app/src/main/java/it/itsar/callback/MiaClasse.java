package it.itsar.callback;

import android.util.Log;

public class MiaClasse {
    public interface MiaInterfaccia {
        public void finito(String ritorno);
        public void crash(String errore);
    }


    public void aspetta(final MiaInterfaccia callback){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    callback.finito("Ho finito sium");
                } catch (InterruptedException e) {
                    callback.crash("Sono crashato\n"+e);
                }

            }
        }).start();
    }
}
