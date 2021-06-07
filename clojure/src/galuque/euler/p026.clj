(ns galuque.euler.p026
  (:gen-class))

(defn unit-fraction [d]
  (loop [n 1 
         i 1 
         known? #{}]
    (let [r (rem (* 10 n) d)]
      (cond (zero? r) 0
            (known? r) i
            :else (recur r (inc i) (conj known? r))))))

(defn reciprocal-cycles [k]
  (let [cycles (reduce (fn [m val]
                         (assoc m val (unit-fraction val)))
                       {}
                       (range 1 k))]
    (->> cycles
         (apply max-key second)
         first)))

(comment
  (time
   (reciprocal-cycles 1000))
  ;; "Elapsed time: 70.170084 msecs"
  ;; => 983
)

(defn -main [arg]
  (println (reciprocal-cycles (Long/parseLong arg))))
