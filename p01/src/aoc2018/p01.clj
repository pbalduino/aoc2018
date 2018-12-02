(ns aoc2018.p01
  (:require [clojure.string :as str]))

(defn- ->numbers [coll]
  (map #(Long/parseLong %) coll))

(defn- part-1 [input]
  (->> input
       ->numbers
       (reduce +)
       println))

(defn- part-2 [input]
  (loop [adjusts (-> input
                     ->numbers
                     cycle)
         frequencies #{0}
         current-frequency 0]
    (let [head (first adjusts)
          current-frequency (+ current-frequency head)]
      (if (frequencies current-frequency)
        (println current-frequency)
        (recur (rest adjusts)
               (conj frequencies current-frequency)
               current-frequency)))))

(defn -main [& args]
  (part-1 args)
  (part-2 args))
