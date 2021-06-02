(ns galuque.euler.p018
  (:gen-class)
  (:require [clojure.string :as str]
            [clojure.java.io :as io]))

(def triangle-str (slurp (io/resource "p018/input.txt")))

(defn- strs->numbers [strs]
  (mapv #(Long/parseLong %) strs))

(def triangle
  (->> triangle-str
       str/split-lines
       (map #(str/split % #" "))
       (map strs->numbers)))

(defn max-path-sum [triangle]
  (first
   (reduce (fn [prev nxt]
             (let [maxs (->> prev
                             (partition 2 1)
                             (map (partial apply max)))]
               (map +' nxt maxs)))
           (reverse triangle))))
(comment
  (max-path-sum triangle)
  ;; => 1074
  )

(defn -main []
  (println (max-path-sum triangle)))
