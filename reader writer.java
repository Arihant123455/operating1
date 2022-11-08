import java.util.concurrent.Semaphore;

class HelloWorld
{

    static Semaphore read = new Semaphore(1);
    static Semaphore wrt = new Semaphore(1);
    static int readCount = 0;

    static class Read implements Runnable
    {

    public
        void run()
        {
            try
            {
                // Acquire Section
                read.acquire();
                readCount++;
                if (readCount == 1)
                {
                    wrt.acquire();
                }
                read.release();

                // Reading section
                System.out.println("Thread " + Thread.currentThread().getName() + " is READING");
                Thread.sleep(1500);
                System.out.println("Thread " + Thread.currentThread().getName() + " has FINISHED READING");

                // Releasing section
                read.acquire();
                readCount--;
                if (readCount == 0)
                {
                    wrt.release();
                }
                read.release();
            }
            catch (InterruptedException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }

    static class Write implements Runnable
    {

    public
        void run()
        {
            try
            {
                wrt.acquire();
                System.out.println("Thread " + Thread.currentThread().getName() + " is WRITING");
                Thread.sleep(2500);
                System.out.println("Thread " + Thread.currentThread().getName() + " has finished WRITING");
                wrt.release();
            }
            catch (InterruptedException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void
    main(String[] args) throws Exception
    {
        Read read = new Read();
        Write write = new Write();
        Thread t1 = new Thread(read);
        t1.setName("thread1");
        Thread t2 = new Thread(read);
        t2.setName("thread2");
        Thread t3 = new Thread(write);
        t3.setName("thread3");
        Thread t4 = new Thread(read);
        t4.setName("thread4");
        Thread t5 = new Thread(write);
        t5.setName("thread5");
        Thread t6 = new Thread(read);
        t6.setName("thread6");
        Thread t7 = new Thread(read);
        t7.setName("thread7");
        Thread t8 = new Thread(read);
        t8.setName("thread8");
        Thread t9 = new Thread(read);
        t9.setName("thread9");
        Thread t10 = new Thread(read);
        t10.setName("thread10");
        Thread t11 = new Thread(write);
        t11.setName("thread11");
        Thread t12 = new Thread(read);
        t12.setName("thread12");
        Thread t13 = new Thread(read);
        t13.setName("thread13");
        Thread t14 = new Thread(write);
        t14.setName("thread14");
        Thread t15 = new Thread(write);
        t15.setName("thread15");
        t1.start();
        t3.start();
        t2.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();
        t11.start();
        t12.start();
        t13.start();
        t14.start();
        t15.start();
    }
