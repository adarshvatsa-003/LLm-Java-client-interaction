from flask import Flask, request, jsonify
from transformers import AutoModelForCausalLM, AutoTokenizer
import torch

# Load the model
model_id = "TinyLlama/TinyLlama-1.1B-Chat-v1.0"
device = torch.device("cpu")
model = AutoModelForCausalLM.from_pretrained(model_id).to(device)
tokenizer = AutoTokenizer.from_pretrained(model_id)

app = Flask(__name__)

@app.route('/generate', methods=['POST'])
def generate_text():
    data = request.json
    texts = data['texts']
    responses = []

    for text in texts:
        input_ids = tokenizer(text, return_tensors="pt").input_ids.to(device)
        outputs = model.generate(input_ids, max_length=50)
        generated_text = tokenizer.decode(outputs[0], skip_special_tokens=True)
        responses.append(generated_text)

    return jsonify({'responses': responses})

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5001)

