(ns galuque.euler.p002
  (:gen-class))

(def fibonacci
  ((fn f [a b]
     (lazy-seq (cons a (f b (+ a b)))))
   1 2))

(defn p2 [limit]
  (transduce (comp
              (take-while #(<= % limit))
              (filter even?))
             +
             0
             fibonacci))

(defn -main [number]
  (println (p2 (Integer/parseInt number))))
