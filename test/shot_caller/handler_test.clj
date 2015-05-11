(ns shot-caller.handler-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [shot-caller.handler :refer :all]))

(deftest test-app
  (testing "main route"
    (let [response (app (mock/request :get "/lead/unique-lead-code"))]
      (is (= (:status response) 200))
      (is (= (:body response) "0"))))

  (testing "not-found route"
    (let [response (app (mock/request :get "/invalid"))]
      (is (= (:status response) 404)))))
