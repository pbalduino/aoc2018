(ns aoc2018.p02-test
  (:require [clojure.test :refer :all]
            [aoc2018.p02  :refer :all]))

(def test-checksum ["abcdef" "bababc" "abbcde" "abcccd" "aabcdd" "abcdee" "ababab"])
(def test-ids      ["abcde" "fghij" "klmno" "pqrst" "fguij" "axcye" "wvxyz"])

(deftest aoc-day-two
  (testing "Test sample checksum"
    (is (= (checksum test-checksum) 12)))

  (testing "Find similarities"
    (is (= (common-code test-ids) "fgij"))))
