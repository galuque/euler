(ns galuque.euler.p5
  (:gen-class))

(defn sum-sqr-difference [k]
  (let [m (-> (reduce (fn [acc n]
                        (-> acc
                            (update-in [:sum]  + n)
                            (update-in [:sqrs] + (* n n))))
                      {:sum 0
                       :sqrs 0}
                      (range 1 (inc k)))
              (update-in [:sum] #(Math/pow % 2)))]
    (int (- (:sum m) (:sqrs m)))))

(comment
  (sum-sqr-difference 100)
  ;; => 25164150
)
