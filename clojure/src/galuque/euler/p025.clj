(ns galuque.euler.p025
  (:gen-class))

(defn fibonacci-seq
  ([]
   (cons 0 (cons 1 (fibonacci-seq 0 1))))
  ([a b]
   (let [nxt (+' a b)]
     (lazy-seq (cons nxt (fibonacci-seq b nxt))))))

(defn count-digits [n]
  (count (str n)))

(def fibonacci-nums (fibonacci-seq))

(defn n-digit-fibonacci [n]
  (->> fibonacci-nums
       (map-indexed (fn [idx num] [idx (count-digits num)]))
       (drop-while #(< (second %) n))
       ffirst))

(comment
  (time
   (n-digit-fibonacci 1000))
  ;; "Elapsed time: 163.055414 msecs"
  ;; => 4782
  )

(defn -main [arg]
  (println (n-digit-fibonacci (Long/parseLong arg))))
