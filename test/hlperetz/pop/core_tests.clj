(ns hlperetz.pop.core-tests
  (:require [clojure.test :refer [deftest is testing run-tests]]
            [hlperetz.pop.core :as pop]))

#_{:clj-kondo/ignore [:unused-binding]}
(deftest query-methods-take-correct-args
  (testing "that the methods of the Query protocol are implemented correctly for each data type"
    (let [sut1 {:a 1 :b 2 :c 3}
          sut2 {:a [1 2 3] :b {:ba 4 :bc 5} :c 6}
          args-1 [:a :b :c]
          [args-2] [:b :c]]
      (is (= (pop/select sut1 :a :b) [1 2])))))

(run-tests)