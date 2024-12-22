# ScoreMe - LLaMA Java Client and Python Server Integration

## Overview

ScoreMe is a project that integrates a Java client with a Python Flask server running a LLaMA model. The Java client communicates with the Python server to generate text responses based on input texts using the LLaMA model.

## Features

- **Java Client**: Sends input texts to the Python server and receives generated text responses.
- **Python Flask Server**: Hosts the LLaMA model and handles text generation requests.

## Prerequisites

### Java Client

- Java JDK 21 or later
- Gradle

### Python Server

- Python 3.9 or later
- `transformers` library
- `torch` library
- `flask` library

## Setup and Installation

### Clone the Repository

```bash
git clone <repository-url>
cd scoremeCl

## About Llm model

Name-TinyLlama/TinyLlama-1.1B-Chat-v1.0
Source- Huggingface

About- This model has exactly the same architecture and tokenizer as Llama 2. This means TinyLlama can be plugged and played in many open-source projects built upon Llama. Besides, TinyLlama is compact with only 1.1B parameters. This compactness allows it to cater to a multitude of applications demanding a restricted computation and memory footprint.


