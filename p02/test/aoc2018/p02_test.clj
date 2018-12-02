(ns aoc2018.p02-test
  (:require [clojure.test :refer :all]
            [aoc2018.p02  :refer :all]))

(def test-checksum ["abcdef" "bababc" "abbcde" "abcccd" "aabcdd" "abcdee" "ababab"])

(deftest verify-checksum
  (testing "Test sample checksum"
    (is (= (checksum test-checksum) 12))))
