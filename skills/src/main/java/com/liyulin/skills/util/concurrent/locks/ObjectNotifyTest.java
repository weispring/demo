package com.liyulin.skills.util.concurrent.locks;

public class ObjectNotifyTest {


    public static void main(String[] args) {
        // System.out.println("lock");

        final OutTurn ot = new OutTurn();

        for (int j = 0; j < 100; j++) {

            new Thread(new Runnable() {

                public void run() {
                    // try {
                    // Thread.sleep(10);
                    // } catch (InterruptedException e) {
                    // e.printStackTrace();
                    // }
                    for (int i = 0; i < 5; i++) {
                        ot.sub();
                    }
                }
            }).start();

            new Thread(new Runnable() {

                public void run() {
                    // try {
                    // Thread.sleep(10);
                    // } catch (InterruptedException e) {
                    // e.printStackTrace();
                    // }
                    for (int i = 0; i < 5; i++) {
                        ot.main();
                    }
                }
            }).start();
        }

    }


  static  class OutTurn {
        private boolean isSub = true;
        private int count = 0;

        public synchronized void sub() {
            try {
                while (!isSub ) {
                    this.wait();
                }
                System. out.println("sub ---- " + count);
                isSub = false ;
                this.notifyAll();
            } catch (Exception e) {
                e.printStackTrace();
            }
            count++;

        }

        public synchronized void main() {
            try {
                while (isSub ) {
                    this.wait();
                }
                System. out.println("main (((((((((((( " + count);
                isSub = true ;
                this.notifyAll();
            } catch (Exception e) {
                e.printStackTrace();
            }
            count++;
        }
    }


}
