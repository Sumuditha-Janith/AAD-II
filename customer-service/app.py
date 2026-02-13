from flask import Flask, jsonify
import py_eureka_client.eureka_client as eureka_client

app = Flask(__name__)
PORT = 5000

eureka_client.init(
    eureka_server="http://localhost:8761/eureka/",
    app_name="customer-service",
    instance_port=PORT
)

@app.route('/api/v1/customer/details')
def details():
    return jsonify({"message": "Customer Service (Python) is Running"})

app.run(port=PORT)