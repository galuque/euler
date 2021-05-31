(ns galuque.euler.p004
  (:gen-class))

(defn palindrome? [n]
  (let [n' (str n)]
    (= (seq n')
       (reverse n'))))

(def largest-palindrome-product
  (let [three-digit-numbers (range 100 1000)]
    (apply max
           (for [x three-digit-numbers
                 y three-digit-numbers
                 :when (palindrome? (* x y))]
             (* x y)))))

(defn -main []
  (println largest-palindrome-product))
