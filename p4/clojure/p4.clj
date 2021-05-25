(ns p4
  (:gen-class))

(defn palindrome? [n]
  (let [n' (str n)]
    (= (seq n')
       (reverse n'))))

(defn three-digit-numbers
  ([]
   (three-digit-numbers 999))
  ([n]
   (when (< 99 n)
     (lazy-seq
      (cons n (three-digit-numbers (dec n)))))))

(def largest-palindrome-product
  (apply max
         (for [x (three-digit-numbers)
               y (three-digit-numbers)
               :when (palindrome? (* x y))]
           (* x y))))

(defn -main []
  (println largest-palindrome-product))
