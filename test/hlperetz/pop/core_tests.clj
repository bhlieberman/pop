(ns hlperetz.pop.core-tests
  (:require [clojure.test :refer [deftest is testing run-tests]]
            [hlperetz.pop.core :as pop]))

(deftest merging-search-params-with-query-works
  (testing "that the ISoql protocol correctly merges search params provided as a map."
    (let [q {:select :all
             :where {:name [:like :ben]}}]
      (is (= q (pop/query q {})))
      (is (= {:select nil
              :where {:name [:like :ben]}} (pop/query q {:select nil
                                                         :where {:name [:like :ben]}}))))))

(run-tests)