(ns galuque.euler.p015
  (:gen-class)
  (:require [galuque.euler.utils :as u :refer [choose]]))

;; This problem is just the ways you can choose 
;; r paths from a n * 2 posible paths of a nxn grid
;; Implemented the factorial function and the choose function
;; in the utils namespace

(comment
  (time
   (choose 40 20))
  ;; "Elapsed time: 3.035416 msecs"
  ;; => 137846528820N
)

(defn -main [arg]
  (let [n (Long/parseLong arg)]
    (println (choose (* n 2) n))))
