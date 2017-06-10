package SkipList;

import java.util.Random;

/**
 * Created by xhu on 5/16/17.
 */
public class SkipList {
    public SkipListEntry head;    // First element of the top level
    public SkipListEntry tail;    // Last element of the top level


    public int n;                 // number of entries in the Skip List

    public int h;       // Height
    public Random r;    // Coin toss

    public SkipList()     // Constructor...
    {
        SkipListEntry p1, p2;

     /* -----------------------------------
        Create an -oo and an +oo object
	----------------------------------- */
        p1 = new SkipListEntry(SkipListEntry.negInf, null);
        p2 = new SkipListEntry(SkipListEntry.posInf, null);


     /* --------------------------------------
        Link the -oo and +oo object together
	--------------------------------------- */
        p1.right = p2;
        p2.left = p1;

     /* --------------------------------------
        Initialize "head" and "tail"
	--------------------------------------- */
        head = p1;
        tail = p2;

     /* --------------------------------------
        Other initializations
	--------------------------------------- */
        n = 0;                   // No entries in Skip List
        h = 0;		      // Height is 0

        r = new Random();	      // Make random object to simulate coin toss
    }

    /* ------------------------------------------------------
     findEntry(k): find the largest key x <= k
                   on the LOWEST level of the Skip List
     ------------------------------------------------------ */

    public SkipListEntry findEntry(String k)
    {
        SkipListEntry p;

     /* -----------------
        Start at "head"
        ----------------- */
        p = head;

        while ( true )
        {
        /* ------------------------------------------------
           Search RIGHT until you find a LARGER entry

           E.g.: k = 34

                     10 ---> 20 ---> 30 ---> 40
                                      ^
                                      |
                                      p must stop here
		p.right.key = 40
           ------------------------------------------------ */
            while ( (p.right.key) != SkipListEntry.posInf &&
                    (p.right.key).compareTo(k) <= 0 )
            {
                p = p.right;         // Move to right
            }

        /* ---------------------------------
           Go down one level if you can...
           --------------------------------- */
            if ( p.down != null )
            {
                p = p.down;          // Go downwards
            }
            else
            {
                break;       // We reached the LOWEST level... Exit...
            }
        }

        return(p);         // Note: p.key <= k
    }

    /** Returns the value associated with a key. */

    public Integer get (String k)
    {
        SkipListEntry p;

        p = findEntry(k);

        if ( k.equals( p.key ) )
            return(p.value);
        else
            return(null);
    }

    public Integer put (String k, Integer v)
    {
        SkipListEntry p, q;
        int       i;

        p = findEntry(k);                  // Try find the entry

     /* ------------------------
        Check if key is found
        ------------------------ */
        if ( k.equals(p.key) )  // If key found, update the value and we are done...
        {
            Integer old = p.value;         // Remember the old value

            p.value = v;                   // Update value

            return(old);		       // Return the old value
        }

     /* -------------------------------------------------------------
        Key k is not found, then p = floorEntry(k) (See: click here)

        The rest of the code will insert a new entry (k,v)
        ------------------------------------------------------------- */

        q = new SkipListEntry(k,v);       // Create a new entry with k and v

     /* --------------------------------------------------------------
        Insert q into the lowest level after SkipListEntry p:

                         p   put q here           p        q
                         |     |                  |        |
		         V     V                  V        V        V
        Lower level:    [ ] <------> [ ]    ==>  [ ] <--> [ ] <--> [ ]
        --------------------------------------------------------------- */
        q.left = p;
        q.right = p.right;
        p.right.left = q;
        p.right = q;

     /* -----------------------------------------------------
        Make a "tower" of the entry e or RANDOM height
	----------------------------------------------------- */

        i = 0;                   // Current level = 0

        while ( r.nextDouble() < 0.5 /* Coin toss */ )
        {
            // Coin toss success ! ---> build one more level !!!

        /* -------------------------------------------------------------------
	   Check if we need to increase the height of the -oo and +oo "pillars
	   ------------------------------------------------------------------- */
            if ( i >= h )   // We reached the top level !!!
            {
                SkipListEntry p1, p2;

   /* -----------------------------
      Make the -oo and +oo entries
      ---------------------------- */
                p1 = new SkipListEntry(SkipListEntry.negInf, null);
                p2 = new SkipListEntry(SkipListEntry.posInf, null);

   /* --------------------
      Link them
      -------------------- */
                p1.right = p2;
                p1.down  = head;

                p2.left = p1;
                p2.down = tail;

                head.up = p1;
                tail.up = p2;

   /* --------------------
      Update head and tail
      -------------------- */
                head = p1;
                tail = p2;

                h = h + 1;         // One more level...
            }

        /* ------------------------------------
           Find first element with an UP-link
           ------------------------------------ */
            while ( p.up == null )
            {
                p = p.left;
            }

	/* --------------------------------
	   Make p point to this UP element
	   -------------------------------- */
            p = p.up;

	/* ---------------------------------------------------
           Add one more (k,*) to the column

	   Schema for making the linkage:

                p <--> e(k,*) <--> p.right
                          ^
		          |
		          v
		          q
	   ---------------------------------------------------- */
            SkipListEntry e;

            e = new SkipListEntry(k, null);  // Don't need the value...

   	/* ---------------------------------------
   	   Initialize links of e
   	   --------------------------------------- */
            e.left = p;
            e.right = p.right;
            e.down = q;

   	/* ---------------------------------------
   	   Change the neighboring links..
   	   --------------------------------------- */
            p.right.left = e;
            p.right = e;
            q.up = e;

            q = e;       // Set q up for next iteration (if there is one)
            // See here for more detail: click here

            i = i + 1;   // Current level increases by one
        }

        n = n + 1;      // One more entry in the Skip List

        return(null);   // No old value
    }
}
