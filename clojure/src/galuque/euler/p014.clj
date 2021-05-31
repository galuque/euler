(ns galuque.euler.p014
  (:gen-class))

(defn collatz-seq [n]
  (cond
    (= 1 n)   (lazy-seq (cons n nil))
    (even? n) (lazy-seq (cons n (collatz-seq (quot n 2))))
    (odd?  n) (lazy-seq (cons n (collatz-seq (inc (* 3 n)))))))


(defn longest-collatz-n [k]
  (let [collatz-lenghts (for [n (range 1 k)]
                          {:n n :count (count (collatz-seq n))})]
    (first
     (apply max-key :count collatz-lenghts))))

(comment
  (time
   (longest-collatz-n 1000000))
   ;; "Elapsed time: 15717.784483 msecs"
   ;; => [:n 837799]
  )

(defn -main [arg]
  (println (longest-collatz-n (Long/parseLong arg))))
